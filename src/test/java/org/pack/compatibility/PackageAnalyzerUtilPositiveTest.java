package org.pack.compatibility;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertEquals;
import static org.pack.compatibility.PackageAnalyzerUtil.isPackageFitInBox;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.pack.compatibility.data.BoxData;
import org.pack.compatibility.data.PackageData;


/**
 * Unit test for positive cases.
 */
@RunWith(Parameterized.class)
public class PackageAnalyzerUtilPositiveTest extends AbstractPackageAnalyzerUtilTest
{
    @Parameterized.Parameters(name = "Run {index}: packWidth={0}, packHeight={1}, boxWidth={2}, boxHeight={3}, expectedResult={4}")
    public static Iterable<Object[]> data()
    {
        //@formatter:off
        return asList(new Object[][] {
              { 19, 9, 10, 20, true },
              { 19, 9, 20, 10, true },
              { 9, 19, 10, 20, true },
              { 9, 19, 20, 10, true },
        });
        //@formatter:on
    }

    public PackageAnalyzerUtilPositiveTest(int packWidth, int packHeight, int boxWidth, int boxHeight, boolean expectedResult)
    {
        super(packWidth, packHeight, boxWidth, boxHeight, expectedResult);
    }

    @Test
    public void shouldPackageFitInBox()
    {
        PackageData packageData = buildPackageData(packWidth, packHeight);
        BoxData boxData = buildBoxData(boxWidth, boxHeight);

        assertEquals(isPackageFitInBox(packageData, boxData), expectedResult);
    }
}
