select
    I.NAME NAME, I.DATETIME DATETIME
from 
    ANIMAL_INS I
where 
    I.ANIMAL_ID not in (select  ANIMAL_ID
                       from     ANIMAL_OUTS)
order by
    I.DATETIME asc
limit 3;