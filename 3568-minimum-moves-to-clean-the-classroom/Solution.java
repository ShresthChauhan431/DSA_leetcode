class Solution {
    public int minMoves(String[] classroom, int energy) {
        Queue<int[]> q = new LinkedList<>();
        int sti = 0;
        int stj = 0;
        List<int[]> litters = new ArrayList<>();
        
        for(int i = 0; i < classroom.length; i++){
            for(int j = 0; j < classroom[i].length(); j++){
                if(classroom[i].charAt(j) == 'S'){
                    sti = i;
                    stj = j;
                } else if(classroom[i].charAt(j) == 'L'){
                    litters.add(new int[]{i, j});
                }
            }
        }
        
        int totalLitters = litters.size();
        int targetMask = (1 << totalLitters) - 1;
    
        boolean[][][][] visited = new boolean[classroom.length][classroom[0].length()][energy + 1][1 << totalLitters];
        
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        
        q.offer(new int[]{sti, stj, 0, energy, 0});
        visited[sti][stj][energy][0] = true;
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int r = arr[0], c = arr[1], steps = arr[2], currE = arr[3], mask = arr[4];
            
            if(mask == targetMask){
                return steps;
            }
            
            for(int[] d: dir){
                int ni = r + d[0];
                int nj = c + d[1];
                
                if(ni < 0 || nj < 0 || ni >= classroom.length || nj >= classroom[0].length()) continue;
                if(classroom[ni].charAt(nj) == 'X') continue;
                
                int newE = currE;
                int newMask = mask;
                
                for(int k = 0; k < totalLitters; k++) {
                    if(litters.get(k)[0] == ni && litters.get(k)[1] == nj) {
                        if((mask & (1 << k)) == 0) { 
                            newMask |= (1 << k);
                        }
                        break; 
                    }
                }
                newE--;
                
                if(classroom[ni].charAt(nj) == 'R') {
                    newE = energy;
                }
                if(newE < 0) continue;
                
                if(!visited[ni][nj][newE][newMask]){
                    visited[ni][nj][newE][newMask] = true;
                    q.offer(new int[]{ni, nj, steps + 1, newE, newMask});
                }
            }
        }

        return -1;
    }
}