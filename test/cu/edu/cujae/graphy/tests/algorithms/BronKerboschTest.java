/*
 * Copyright (C) 2022 Amaya.
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

import cu.edu.cujae.graphy.algorithms.BronKerboschAlgorithm;
import cu.edu.cujae.graphy.core.Graph;
import cu.edu.cujae.graphy.core.utility.GraphBuilders;
import cu.edu.cujae.graphy.utils.Tuple;
import java.util.Set;

/**
 * 
 * @author Amaya D. Fuentes
 */
public class BronKerboschTest {
    
    public static void callBronKerbosch(Graph<Integer> graph){
        
        Tuple<Set<Integer>> result = (Tuple<Set<Integer>>)new BronKerboschAlgorithm(graph).apply().get();
        result.freeze();
        
        System.out.print("          Maximal cliques: ");
        if(result.isEmpty()) {
            System.out.println("NONE");
        }
        else {
            for(Set<Integer> clique: result) {        
                System.out.print(clique.toString());
            }
            System.out.println("\n");
        }
    }
    
    public static void main(String[] args) {
        
        Graph<Integer> g1 = GraphBuilders.makeSimpleGraph(false);
        for(int i = 1; i < 7; i++) {
            g1.add(i, i);
        }
        g1.connect(1, 2);
        g1.connect(1, 5);
        g1.connect(2, 3);
        g1.connect(2, 5);
        g1.connect(3, 4);
        g1.connect(4, 5);
        g1.connect(4, 6);
        
        System.out.println("Graph 1 - Edges: (1<->2) (1<->5) (2<->3) (2<->5) (3<->4) (4<->5) (4<->6) ");
        callBronKerbosch(g1);
    
        Graph<Integer> g2 = GraphBuilders.makeSimpleGraph(false);
        for(int i = 1; i < 4; i++) {
            g2.add(i, i);
        }
        g2.connect(1, 2);
        g2.connect(1, 3);
        g2.connect(2, 3);
  
        System.out.println("Graph 2 - Edges: (1<->2) (2<->3) (3<->1) ");
        callBronKerbosch(g2);
    
        
        Graph<Integer> g3 = GraphBuilders.makeSimpleGraph(false);
        for(int i = 1; i < 8; i++) {
            g3.add(i, i);
        }
        g3.connect(1, 2);
        g3.connect(1, 3);
        g3.connect(1, 4);
        g3.connect(2, 3);
        g3.connect(2, 4);
        g3.connect(2, 5);
        g3.connect(3, 4);
        g3.connect(4, 5);
        g3.connect(4, 6);
        g3.connect(5, 7);
        
        System.out.println("Graph 3 - Edges: (1<->2) (1<->3) (1<->4) (2<->3) (2<->4) (2<->5) (3<->4) (4<->5) (4<->6) (5<->7) ");
        callBronKerbosch(g3);
       
        Graph<Integer> g4 = GraphBuilders.makeSimpleGraph(false);
        for(int i = 1; i < 8; i++) {
            g4.add(i, i);
        }
        g4.connect(1, 2);
        g4.connect(1, 3);
        g4.connect(2, 3);
        g4.connect(4, 5);
       
        System.out.println("Graph 4 - Edges: (1<->2) (2<->3) (3<->1) (4<->5) ");
        callBronKerbosch(g4);
    }
    
}
