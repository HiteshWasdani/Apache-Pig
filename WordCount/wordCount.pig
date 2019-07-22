A = LOAD '/wordCountInput' as (lines:chararray);
B = FOREACH A GENERATE FLATTEN(TOKENIZE(lines)) as word;
C = GROUP B BY word;
D = FOREACH C GENERATE group,COUNT(B);
DUMP D;
