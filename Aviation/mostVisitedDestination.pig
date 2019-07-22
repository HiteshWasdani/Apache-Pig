dataset = load '/home/hitesh/Desktop/dataset/DelayedFlights.csv' using PigStorage(',');
data = filter dataset by $1 != 'Year';
filter_data = foreach data generate $18 as dest:chararray;
group_data = group filter_data by dest;
top_dest = foreach group_data generate group as dest, COUNT(filter_data) as count;
result11 = order top_dest by count desc;
dump result11;
