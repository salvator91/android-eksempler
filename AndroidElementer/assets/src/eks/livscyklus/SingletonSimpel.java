/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eks.livscyklus;

public class SingletonSimpel {
	public Programdata programdata = new Programdata();

	public static SingletonSimpel instans = new SingletonSimpel();
}
