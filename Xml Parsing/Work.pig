register '/home/hitesh/Desktop/piggybank-0.17.0.jar' ; 
DEFINE XPath org.apache.pig.piggybank.evaluation.xml.XPath();

a = load '/home/hitesh/Desktop/xmlInput.xml' using org.apache.pig.piggybank.storage.XMLLoader('Book') as (x:chararray);

b = foreach a generate XPath(x, 'Book/BookId') as (BookId:int), XPath(x, 'Book/Category') as (Category:chararray), XPath(x,'Book/Location') as (Location:chararray);

result = foreach b generate BookId, Category, FLATTEN(TOKENIZE(REPLACE(Location,'\\|',',')));

dump result;
