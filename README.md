# CompSt 751 Group Project

## Name

Please put your current or desired project name here.

Project Name - ZIP Trees

## People

Please list all the team members with name, github username and email,e.g. 
John Boyland, @boyland, boyland@uwm.edu

Aditya Sankranthi ,@Aditya-Sankranthi , sankran5@uwm.edu 
Manasa Jayasri Thambabathula,@manasa-uwm ,thambab2@uwm.edu 
Satish Jagadish,@Satish7940, jagadis2@uwm.edu


## Paper

Give the URL to the ACM digital library for the paper you will be replicating.

https://dl.acm.org/doi/abs/10.1145/3476830


### Scope

Describe what you will be implementing.

Base Implementation: The core of the project involves coding the Zip Trees data structure, incorporating key operations such as insertion, deletion, and search, following the algorithmic descriptions provided in the paper.

Insertion: We will incorporate a new node by assigning it a random rank, integrating it into the tree while ensuring the preservation of the heap order, based on ranks, alongside the binary search tree properties.

Deletion: We will remove nodes from the tree and subsequently restructure it to maintain the heap order and binary search tree properties. This process may involve the recombination of two subtrees to ensure the tree's integrity.

Search: We will implement search functionality similar to traditional binary search trees, traversing the tree based on key comparisons to locate the desired node efficiently.

These operations are facilitated by the novel concept of "zipping" and "unzipping" the tree for restructuring, which is simpler and potentially more efficient than the rotations used in AVL or red-black trees. The implementation focuses on the practical application of the theoretical principles discussed, including the random rank assignment and the management of these ranks to ensure the tree's efficiency and balance.

### Artifacts found

Give URLs of code provided by the authors of the paper or their collaborators.

## Plan

### Main classes

What classes will you implement to demonstrate the technique of the paper?

The main classes to implement for demonstrating the Zip Trees technique would include:

ZipTree: This class represents the core Zip Tree data structure, incorporating methods for insertion, deletion, and search operations based on the algorithmic descriptions provided in the paper.
ZipNode: This class represents the nodes within the Zip Tree, each containing a key, a random rank, and references to its left and right children.

### Helper classes

Are there any helpers you need to implement?
These can be from other open source projects, as long as you credit them

No specific helper classes from other open-source projects are mentioned. However, depending on the language and framework used, standard libraries or utilities for testing (e.g., JUnit for Java) may be leveraged.

### Test Suites

Provide a section for each test suite that is planned and a paragraph describing what it will do.

Functionality testing/Primary testing (TestZipTrees.java):
This suite focuses on functionality testing, including unit tests for insertion, deletion, and search operations. It will cover normal cases, boundary conditions, and error scenarios to ensure the correctness of each operation under various circumstances. For insertion, tests will validate that elements are added correctly while maintaining the tree properties. Deletion tests will ensure accurate removal of elements without compromising the tree's integrity, and search tests will confirm the correct retrieval of elements.

Efficiency Tests (TestEfficiency.java):
This suite assesses the efficiency of Zip Tree operations, particularly focusing on their time complexity. Its objective is to compare the performance of insertion, deletion, and search operations against theoretical expectations, offering insights into the practical effectiveness of the Zip Trees data structure. Additionally, it conducts identical tests on Binary Search Trees for a comparative analysis.

#### Functionality testing
This suite focuses on functionality testing, including unit tests for insertion, deletion, and search operations. It aims to ensure the correctness of each operation under various circumstances.
##### Insertion
- **Sequential Insertion**: Tests adding elements in a sequential manner to assess the tree's ability to maintain order and balance.
- **Same Rank Insertion**: Evaluates the tree's handling of elements inserted with identical ranks, ensuring proper rank distribution and tree balance.
- **Balance and Rank Validation**: After insertion operations, checks are performed to validate the tree's balance and the correct distribution of ranks.

##### Deletion
- **Positional Removal**: Tests involve removing elements from different positions (leaf, middle, root) to verify the tree's structural integrity and property maintenance.
- **Structural Integrity**: Ensures the tree correctly restructures itself after deletions, maintaining proper heap order and binary search properties.

##### Search
- **Existence Check**: Verifies that the search operation can successfully locate and return a node or value for an element that exists within the tree.
- **Non-Existence Check**: Confirms that searches for elements not present in the tree accurately return a null or false indication, show casing the tree's proper handling of such cases.
- **Boundary Conditions**: Tests the search functionality against boundary conditions, including searching for the smallest and largest elements, as well as operations on an empty tree.

## Status

Add section using the current date as the heading and describe the status in a few sentences or a few paragraphs.

Status (as of current date: 02-19-2024)
The project plan is well-defined, with the main classes identified and comprehensive test suites outlined to ensure the functionality and efficiency of the Zip Trees implementation. The initial coding phase is underway, with a focus on meeting the outlined milestones and completing the primary functionality tests.

Status (as of current date: 03-03-2024)
We've included some key resources that will help us build and refine our Zip Trees implementation in Java. We've looked into Rust implementation and understand better how to handle insertions, deletions. We also included the existing implementations of BST which we will use to perform comparative analysis.

Status (as of current date: 03-07-2024)
Configured Junit4 test suite , Created Interface file (TreeInterface) for AVL and ZIP Tree ADTs .Implemented AVL tree methods except delete, established a skeleton Zip tree class inheriting  methods from TreeInterface, and created test cases for AVL insert and search method. Focus is on implementing ZIP tree and compare the efficiency with AVL tree also enhancing tests and improving documentation. 

Status (as of current date: 03-19-2024)
Completed the implementation of the AVL Tree data structure with all essential methods, including the delete method. Added few test cases testing various scenarios of AVLTree implementation. These tests rigorously examine the behavior of the AVL Tree under various deletion scenarios, ensuring adherence to the AVL balancing properties.

Status (as of current date: 03-31-2024)
For the ZipTree class, essential methods for insertion, deletion, and search have been coded up, following the interface guidelines. Initial tests have been put in place to confirm that these methods are functioning correctly, laying the groundwork for further development and comparison with the AVL Tree's performance.

Status (as of current date: 04-14-2024)
Added all the methods for the ZIP Tree file and included the Efficiency Test file, along with the required test cases to compare both the ZIP tree and AVL tree. We observed a very small time difference in the execution of the test cases, where the ZIP tree test cases executed faster than the AVL tree. However, the time difference is very small. We plan to design better test cases to establish a legitimate difference in efficiency between AVL and ZIP Trees. 


