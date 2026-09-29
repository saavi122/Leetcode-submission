# Write your MySQL query statement below
select a.name from Employee a join Employee b on a.id = b.managerId group by b.managerId having COUNT(*) >= 5;