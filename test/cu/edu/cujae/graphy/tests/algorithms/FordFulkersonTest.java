/*
 * Copyright (C) 2022 Asus.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package cu.edu.cujae.graphy.tests.algorithms;

import cu.edu.cujae.graphy.algorithms.FordFulkersonAlgorithm;
import cu.edu.cujae.graphy.core.WeightedGraph;
import cu.edu.cujae.graphy.core.utility.GraphBuilders;
import cu.edu.cujae.graphy.core.utility.Weights;

/**
 *
 * @author Amanda Mendez
 */
public class FordFulkersonTest
{

    public static void main(String[] args)
    {
        WeightedGraph<Integer> graph = GraphBuilders.makeSimpleWeightedGraph(true);

        for (int i = 0; i < 6; ++i)
        {
            graph.add(i);
        }

        graph.connect(0, 1, Weights.makeWeight(16.0f));
        graph.connect(0, 2, Weights.makeWeight(13.0f));
        graph.connect(1, 2, Weights.makeWeight(10.0f));
        graph.connect(1, 3, Weights.makeWeight(12.0f));
        graph.connect(2, 1, Weights.makeWeight(4.0f));
        graph.connect(2, 4, Weights.makeWeight(14.0f));
        graph.connect(3, 2, Weights.makeWeight(9.0f));
        graph.connect(3, 5, Weights.makeWeight(20.0f));
        graph.connect(4, 3, Weights.makeWeight(7.0f));
        graph.connect(4, 5, Weights.makeWeight(4.0f));

        System.out.println(graph);

        System.out.println("Ford Fulkerson: ");
        System.out.println(new FordFulkersonAlgorithm(graph, graph.iterator(0), graph.iterator(5)).apply().get());
    }
}
