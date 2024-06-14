select
    A.ID, ifnull(B.cnt, 0) CHILD_COUNT
from
    ECOLI_DATA A
left join (
    select
        PARENT_ID ID, count(*) cnt
    from
        ECOLI_DATA  
    group by
        PARENT_ID
    ) B
on A.ID = B.ID
order by
    A.ID