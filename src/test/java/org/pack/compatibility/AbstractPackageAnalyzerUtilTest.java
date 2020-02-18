package org.pack.compatibility;

import org.pack.compatibility.data.BoxData;
import org.pack.compatibility.data.PackageData;


public class AbstractPackageAnalyzerUtilTest
{
	protected int packWidth;
	protected int packHeight;
	protected int boxWidth;
	protected int boxHeight;
	protected boolean expectedResult;

	public AbstractPackageAnalyzerUtilTest(int packWidth, int packHeight, int boxWidth, int boxHeight, boolean expectedResult)
	{
		this.packWidth = packWidth;
		this.packHeight = packHeight;
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		this.expectedResult = expectedResult;
	}

	protected PackageData buildPackageData(int width, int height)
	{
		PackageData pack = new PackageData();
		pack.setWidth(width);
		pack.setHeight(height);

		return pack;
	}

	protected BoxData buildBoxData(int width, int height)
	{
		BoxData box = new BoxData();
		box.setWidth(width);
		box.setHeight(height);

		return box;
	}
}
