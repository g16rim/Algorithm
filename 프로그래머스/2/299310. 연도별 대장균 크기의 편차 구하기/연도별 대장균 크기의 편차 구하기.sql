select 
    year(A.DIFFERENTIATION_DATE) YEAR, 
    B.MAX - A.SIZE_OF_COLONY YEAR_DEV, 
    A.ID
from
    ECOLI_DATA A
inner join (
    select
        year(DIFFERENTIATION_DATE) YEAR, max(SIZE_OF_COLONY) MAX
    from 
        ECOLI_DATA
    group by
        year(DIFFERENTIATION_DATE)
    ) B
on 
    year(A.DIFFERENTIATION_DATE) = B.YEAR
order by
    YEAR, YEAR_DEV