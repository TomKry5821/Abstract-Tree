# Abstract Tree
#### Project purpose - Create and test a program to simulate tree growth over time.

#### How it works
In program, we have Abstract class Tree from which two classes inherit:
 - LeafTree
 - Conifer

These classes differ in the type of foliage and in the rates of leaf growth and leaf drop ratios. 

A Tree class include a one trunk, which in turn consists of many branches, which consists of many leaves.
Methods that are actually available:
- grow(): A method that simulates the process of tree growth, during which a tree grows and produces new branches and leaves/needles. How many new leaves appear depends on the leaf growth rate.
Growth rate is used to calculate the amount of new leaves a tree has produced. For simplicity, when the grow method is called, the tree grows by 1 meter, produces a new branch (the others grow by 1 centimeter) and produces more leaves on older branches.
- shedLeaves(): method that simulates the process of leaf loss from the tree during which on each branch number of leaves/needles decreases
depending on leaf drop ratio.
- fallDown(): method that simulates trunk felling process during which tree loses all branches and leaves/needles.

All model elements were successfully tested for various cases using JUnit5.
