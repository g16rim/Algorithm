select
    A.PRODUCT_ID PRODUCT_ID, A.PRODUCT_NAME PRODUCT_NAME, A.PRICE * B.AMOUNT TOTAL_SALES
from
    FOOD_PRODUCT A join (select
                            PRODUCT_ID, sum(AMOUNT) AMOUNT
                        from
                            FOOD_ORDER
                        where
                            PRODUCE_DATE like '2022-05%'
                        group by
                            PRODUCT_ID) B 
    on A.PRODUCT_ID = B.PRODUCT_ID
order by    
    TOTAL_SALES desc, PRODUCT_ID asc;
