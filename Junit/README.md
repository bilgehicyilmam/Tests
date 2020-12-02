# Testing

In testing, I have used Junit 5. I have created a test class called RunningAverageTest. I have
written five test methods which is annotated with @Test to specify that the method is a test
method. Each test runs independently from the other tests.

In every test method, after initializing the object calling constructor currentAverage and
populationSize is initialized as zero (0). After that, I have used assertEquals(expected, actual)
to test the equality of two values.

**In addElement method:** After calling the constructor, we add assertAll to allow all the asserts
to execute without stopping. We can see that if we add array lists by calling RunningAverage
addElement method, the actual values to check against expected becomes same with the
expected values. This method doesn’t return error.

**In getCurrentAverage method:** After calling the constructor we add a list first. With
assertEquals method we can see that expected currentAverage and actual currentAverage
returns the same value. There is no error.

**In getPopulationSize method:** After calling the constructor we add a list first. With
assertEquals method we can see that expected populationSize and actual populationSize returns
the same value. There is no error.

**In removeElement method:** After calling the constructor, we add assertAll to allow all the
asserts to execute without stopping. In this, we execute assertEquals to check the actual and
expected values returns the same values. Firstly, we add a list to implement remove method.
Secondly, we remove a list by calling RunningAverage removeElement method to check the
actual and expected values are same.

**In combine method:** After calling the constructor twice, we create two different lists with two
constructors. When we combine two different lists, we get the average of the overall population
and the sum of the two population sizes. The actual and the expected curentAverage and
populationSize values becomes same, when we combine the two lists. It returns no error.
