# Write your MySQL query statement below
Select e.name, b1.bonus From Employee as e Left Join Bonus as b1 on e.empId = b1.empId where b1.bonus < 1000 or b1.bonus is null