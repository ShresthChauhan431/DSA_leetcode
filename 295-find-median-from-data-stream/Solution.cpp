class MedianFinder {
public:
    multiset<int> ms1;
    multiset<int> ms2;
    MedianFinder() {}

    void addNum(int num) {
        ms2.insert(num);
        if (ms1.size() != 0 && *ms1.rbegin() > *ms2.begin()) {
            int x = *ms1.rbegin();
            int y = *ms2.begin();
            auto at = ms2.find(y);
            auto it = ms1.find(x);
            ms1.erase(it);
            ms2.erase(at);
            ms1.insert(y);
            ms2.insert(x);
        }
        if(ms1.size() < ms2.size()){
            int curr = *ms2.begin();
            ms1.insert(curr);
            auto at = ms2.find(curr);
            ms2.erase(at);
        }
    }

    double findMedian() {
        if(ms1.size() == ms2.size()){
            double x = *ms1.rbegin();
            double y = *ms2.begin();
            return (x + y) /2;
        }else{
            return *ms1.rbegin();
        }
    }
};

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */