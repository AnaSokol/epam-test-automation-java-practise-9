Task

To create type Matrix, which incapsulates two-dimensional array-matrix
block of real (double) type.

Matrix is the cover for two-dimensional array of real values, storing matrix
values with operations of matrix addition, deduction and multiplication.

Real type values (double) can be in matrix, specifying during creation, the
number of array rows and columns, which will store these values. After
creation, the number of rows and columns are not changed. Values to matrix
elements can be set while creating matrix, and later with the help of indexer.
Matrix can provide information regarding the number of array rows and
columns, receive array elements in form of two-dimensional standard array,
add, deduct and multiply matrixes compatible by size. If a user is trying to
perform operations with matrix of incompatible sizes – user type exceptions
MatrixException are thrown from operations. Other matrix methods also
throw exceptions, if a user applies them incorrectly (conveys incorrect
parameters into constructor, in indexer – non-existing index and so on).

Implementation of the following functionality is required in Matrix class:

• Creating of empty matrix with predetermined number of rows and
columns (all values in matrix equal 0).

• Creating of matrix based on existing two-dimensional array.

• Receiving of number of matrix rows and columns.

• Receiving of standard two-dimensional array out of matrix.

• Access to recording and reading of elements via predetermined correct
index (indexer).

• Method of matrixes addition.

• Method of matrixes deduction.

• Method of matrixes multiplication.

• Raise exceptions specified in Javadoc-comments to class methods. 