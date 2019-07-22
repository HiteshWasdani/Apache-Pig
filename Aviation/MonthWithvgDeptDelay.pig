dataset = load '/home/hitesh/Desktop/dataset/DelayedFlights.csv' using PigStorage(',');
data = filter dataset by $1 != 'Year';
filter_data = foreach data generate $2 as month:chararray, $16 as deptDelay:float;
useful_data = filter filter_Data by deptDelay is not null;
group_data = group useful_data by month;
result = foreach group_data generate group as month, AVG(useful_data.deptDelay) as avgDelay;
finalResult = order result by avgDelay  desc;
output11 = limit finalResult 1;
dump output1;

