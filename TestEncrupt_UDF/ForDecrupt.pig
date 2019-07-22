register 'TestEncrupt.jar'; 
A = LOAD '/sripigdata.txt' using PigStorage(',') as (fname:chararray,lname:chararray);
B = FOREACH A GENERATE com.Test(fname,0),name,CONCAT(fname,lname); 
DUMP B;