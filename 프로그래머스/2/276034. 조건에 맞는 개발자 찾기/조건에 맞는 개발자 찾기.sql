-- 코드를 작성해주세요
select      D.ID, D.EMAIL, D.FIRST_NAME, D.LAST_NAME
from        DEVELOPERS D
where       D.SKILL_CODE & (select  CODE
                           from     SKILLCODES
                           where    NAME = 'Python') 
            or D.SKILL_CODE & (select   CODE
                              from      SKILLCODES
                              where     NAME = 'C#')
order by    D.ID;