/**
 * FractionTests.java
 * Author: Nicholas Witmer
 * Revision: 1, Nicholas Witmer
 * Date: 10/4/2015
 * Used to run all unittests for this project at once
 */

package fraction;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FractionTest.class, IllegalArgument.class })
public class FractionTests
{

}
