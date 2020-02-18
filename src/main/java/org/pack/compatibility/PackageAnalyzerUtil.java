package org.pack.compatibility;

import static java.util.Arrays.sort;

import org.pack.compatibility.data.BoxData;
import org.pack.compatibility.data.PackageData;


/**
 * Package analyzer util.
 */
public class PackageAnalyzerUtil
{
    /**
     * Check is package fir into a box.
     *
     * @param pack
     * 		package
     * @param box
     * 		box
     * @return true if package fit into a box, otherwise return false
     */
    public static boolean isPackageFitInBox(PackageData pack, BoxData box)
    {
        int[] sortedPackEdges = getSortedEdges(pack);
        int[] sortedBoxEdges = getSortedEdges(box);

        //@formatter:off
        return sortedPackEdges[0] < sortedBoxEdges[0]
              && sortedPackEdges[1] < sortedBoxEdges[1];
        //@formatter:on
    }

    private static int[] getSortedEdges(PackageData pack)
    {
        int[] edges = { pack.getHeight(), pack.getWidth() };
        sort(edges);

        return edges;
    }

    private static int[] getSortedEdges(BoxData box)
    {
        int[] edges = { box.getHeight(), box.getWidth() };
        sort(edges);

        return edges;
    }
}
