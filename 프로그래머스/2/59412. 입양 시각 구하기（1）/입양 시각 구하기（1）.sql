SELECT
    TO_CHAR(TO_CHAR(DATETIME, 'hh24'),'FM90') AS HOUR,
    COUNT(ANIMAL_ID) AS COUNT
FROM
    ANIMAL_OUTS 
WHERE
    TO_CHAR(DATETIME, 'hh24') >= 9
    AND TO_CHAR(DATETIME, 'hh24') < 20
GROUP BY
    TO_CHAR(DATETIME, 'hh24')
ORDER BY
    TO_CHAR(DATETIME, 'hh24')
;