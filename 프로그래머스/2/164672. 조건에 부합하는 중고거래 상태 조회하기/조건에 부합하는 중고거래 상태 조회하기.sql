select
    BOARD_ID, WRITER_ID, TITLE, PRICE, case STATUS
                                        when 'DONE' then '거래완료'
                                        when 'RESERVED' then '예약중'
                                        else '판매중'
                                        end STATUS
from
    USED_GOODS_BOARD
where
    CREATED_DATE like '2022-10-05%'
order by
    BOARD_ID desc;