select
    F.ID, I.FISH_NAME, F.LENGTH
from
    FISH_INFO F
inner join (
    select
        FISH_TYPE, max(LENGTH) LENGTH
    from
        FISH_INFO
    group by
        FISH_TYPE
) M
on 
    F.FISH_TYPE = M.FISH_TYPE and F.LENGTH = M.LENGTH
inner join
    FISH_NAME_INFO I
on 
    F.FISH_TYPE = I.FISH_TYPE
order by
    F.ID
    
    