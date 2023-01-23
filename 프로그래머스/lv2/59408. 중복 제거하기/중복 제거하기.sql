-- 코드를 입력하세요
SELECT count(B.name)
from (select distinct A.name
     from ANIMAL_INS A) B