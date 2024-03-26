-- 코드를 작성해주세요
select      I.ITEM_ID, I.ITEM_NAME, I.RARITY
from        ITEM_INFO I, ITEM_TREE T
where       I.ITEM_ID = T.ITEM_ID and T.PARENT_ITEM_ID in (select   ITEM_ID
                                                           from     ITEM_INFO
                                                           where    RARITY = 'RARE')
order by    I.ITEM_ID desc;