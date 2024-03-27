select 
    HISTORY_ID, CAR_ID, left(START_DATE, 10) START_DATE, left(END_DATE, 10) END_DATE, case 
                                                                        when DATEDIFF(END_DATE, START_DATE) >= 29 then '장기 대여'
                                                                        else '단기 대여'
                                                                        end RENT_TYPE
from
    CAR_RENTAL_COMPANY_RENTAL_HISTORY
where 
    START_DATE like '2022-09%'
order by
    HISTORY_ID desc;