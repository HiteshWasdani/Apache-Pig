dataset = load '/home/hitesh/Desktop/dataset/DelayedFlights.csv' using PigStorage(',');
data = filter dataset by $1 != 'Year';
filter_data = foreach data generate $2 as month:chararray, $26 as delay:float;
useful_data = filter filter_data by delay is not null;
group_data = group useful_data by month;
result = foreach group_data generate group as month, SUM(useful_data.delay) as delayCount;
finalResult = order result by delayCount desc;
output11 = limit finalResult 1;
dump output11;
