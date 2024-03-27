select
    CAR_ID, round(avg(DATEDIFF(END_DATE, START_DATE)), 1) + 1 AVERAGE_DURATION
from 
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
group by
    CAR_ID
having round(avg(DATEDIFF(END_DATE, START_DATE)), 1) + 1 >= 7
order by
    AVERAGE_DURATION desc, CAR_ID desc;