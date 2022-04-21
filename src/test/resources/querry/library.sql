select count(*) from book_borrow where returned_date is null;

SELECT book_categories.name, COUNT(*) AS countofbookcategories
FROM book_borrow INNER JOIN books ON book_borrow.book_id = books.id
INNER JOIN book_categories ON
books.book_category_id = book_categories.id GROUP BY book_categories.name
ORDER BY countofbookcategories DESC;

SELECT bb.name, COUNT(*) AS countofbookcategories
FROM book_borrow, books b
                 INNER JOIN book_categories bb ON
        b.book_category_id = bb.id GROUP BY bb.name
ORDER BY countofbookcategories DESC;