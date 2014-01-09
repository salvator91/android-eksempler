/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lekt09_livscyklus;

public class SingletonFuld {
  private Programdata programdata = new Programdata();

  private static SingletonFuld instansen;

  public static SingletonFuld getInstans() {
    if (instansen == null) {
      instansen = new SingletonFuld();
    }
    return instansen;
  }

  public Programdata getProgramdata() {
    return programdata;
  }
}