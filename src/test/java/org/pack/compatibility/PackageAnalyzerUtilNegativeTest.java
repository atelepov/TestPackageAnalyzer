package org.pack.compatibility;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.pack.compatibility.PackageAnalyzerUtil.isPackageFitInBox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.pack.compatibility.data.BoxData;
import org.pack.compatibility.data.PackageData;


/**
 * Unit test for negative cases.
 */
@RunWith(Parameterized.class)
public class PackageAnalyzerUtilNegativeTest extends AbstractPackageAnalyzerUtilTest
{
    @Parameterized.Parameters(name = "Run {index}: packWidth={0}, packHeight={1}, boxWidth={2}, boxHeight={3}, expectedResult={4}")
    public static Iterable<Object[]> data()
    {
        //@formatter:off
        return asList(new Object[][] {
              { 20, 9, 10, 20, false },
              { 21, 9, 10, 20, false },
              { 19, 10, 10, 20, false },
              { 19, 11, 10, 20, false },
              { 19, 9, 5, 20, false },
        });
        //@formatter:on
    }

    public PackageAnalyzerUtilNegativeTest(int packWidth, int packHeight, int boxWidth, int boxHeight, boolean expectedResult)
    {
        super(packWidth, packHeight, boxWidth, boxHeight, expectedResult);
    }

    @Test
    public void shouldPackageFitNotInBox()
    {
        PackageData packageData = buildPackageData(packWidth, packHeight);
        BoxData boxData = buildBoxData(boxWidth, boxHeight);

        assertEquals(isPackageFitInBox(packageData, boxData), expectedResult);
    }
}
