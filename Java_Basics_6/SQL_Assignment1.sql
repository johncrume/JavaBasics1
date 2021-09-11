/*
*
*1.	How many copies of the book titled The Lost Tribe are owned by the library branch whose name is "Sharpstown"?
*
*/

SELECT noOfCopies
FROM ( (tbl_book NATURAL JOIN tbl_book_copies ) NATURAL JOIN tbl_library_branch )
WHERE title='The Lost Tribe' AND branchName='Sharpstown';

/*
*
*2.	How many copies of the book titled The Lost Tribe are owned by each library branch?
*
*/
SELECT branchName, noOfCopies
FROM ( (tbl_book NATURAL JOIN tbl_book_copies ) NATURAL JOIN tbl_library_branch )
WHERE Title='The Lost Tribe';

/*
*
*3.	Retrieve the names of all borrowers who do not have any books checked out .
*
*/

SELECT Name
FROM tbl_borrower B
WHERE NOT EXISTS ( SELECT *
 FROM tbl_book_loans L
 WHERE B.cardNo = L.cardNo )
 ;
 /*
*
*4.	For each book that is loaned out from the "Sharpstown" branch and whose DueDate is today, 
*retrieve the book title, the borrower's name, and the borrower's address.
* NOTE: I used '2019-06-07 00:00:00' as value for due date instead of CURRENT_DATE
*/
SELECT B.title, R.name, R.address
FROM tbl_book B, tbl_borrower R, tbl_book_loans BL, tbl_library_branch LB
WHERE LB.branchName='Sharpstown' AND LB.branchId=BL.branchId AND
BL.dueDate='2019-06-07 00:00:00' AND BL.cardNo=R.cardNo AND BL.bookId=B.bookId 
;
/*
*
*5.	For each library branch, retrieve the branch name and the total number of books loaned out from that branch.
*
*/
SELECT L.branchName,COUNT(*)
FROM tbl_book_loans BL, tbl_library_branch L
WHERE BL.branchId = L.branchId
GROUP BY L.branchName
;
/*
*
*6.	Retrieve the names, addresses, and number of books checked out for all borrowers who have more than five books checked out.
*
*/
SELECT B.name, B.address, COUNT(*)
FROM tbl_borrower B, tbl_book_loans L
WHERE B.cardNo = L.cardNo
GROUP BY B.cardNo
HAVING COUNT(*) > 5
;

/*
*
*7.For each book authored (or co-authored) by "Stephen King", retrieve the title and the number of copies owned by the library branch whose name is "Central"
*
*/
SELECT title, noOfCopies
FROM ( ( (tbl_author NATURAL JOIN tbl_book)
NATURAL JOIN tbl_book_copies)
NATURAL JOIN tbl_library_branch)
WHERE authorName = 'Stephen King' and branchName = 'Central'
; 
