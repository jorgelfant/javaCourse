package i_poo.v_design_patterns.D_OtherPatterns_WEB;

public class II_Business_Delegate_III {
  public static void main(String[] args) {

  }
}
//======================================================================================================================
//                                                Principes
//======================================================================================================================
/*
La partie cliente de cette communication doit prendre en compte l'organisation de la partie serveur, les protocoles
choisis et les exigences techniques identifiées, dont la possibilité d'ajouter ultérieurement un cache coté client.
Par ailleurs, le client et les façades métiers s'échangent des données sous forme d'objets de transfert.
*/
//======================================================================================================================
//                                              Cache client
//======================================================================================================================
/*
Certains débits réseaux pouvant être très bas (64 kbps), il est envisagé d'introduire un cache coté client afin
d'accélérer le fonctionnement de l'application dans ce type d'environnement. Il est donc nécessaire de mettre
d'encapsuler la sortie de la couche client dans un Business Delegate qui pourra supporter le cache.
*/
//======================================================================================================================
//                                            Business Delegate
//======================================================================================================================
/*
Nous utiliserons un Business Delegate pour :

    .Réduire le couplage entre la couche métier et la couche présentation
    .Cacher la complexité de manipulation des objets métiers distribués, par encapsulation
    .Mettre en cache les références distantes (et, ultérieurement les résultats)
    .Répartir plus facilement le travail entre les développeurs de la couche présentation et les développeurs
     de la couche métier

Le principe est d'implémenter une classe business delegate par façade métier, en reprenant les méthodes métier,
avec leur signature. Chaque business delegate gérera les exceptions bas niveau, en particulier les problèmes de
déconnexion.

Les recherches JNDI et la manipulation des home seront factorisés dans un objet « Service Locator ».

Les préoccupations périphériques au métiers pourront être prises en compte par le delegate :

   .Gestion d'un cache de données
   .Gestion et transmission de l'authentification
*/
//======================================================================================================================
//                                            Service Locator
//======================================================================================================================
/*
   .Centraliser toutes les utilisations de JNDI et de l'objet InitialContext
   .Améliorer les performances d'accès aux home (par utilisation d’un cache)
   .Fournir un seul point de contrôle
   .Recherche les EJB home et crée les EJB

Ce pattern apporte de la flexibilité et de l’extensibilité au niveau framework.
*/
//======================================================================================================================
//                                            Transfer Object
//======================================================================================================================
/*
Les échanges entre les couches se font grâce à des objets de transfert, ou à des listes d'objets de transfert.
Ces objets sont des java beans, sans méthode métier, dont la responsabilité est uniquement de transporter des données.
Ces beans seront différents de ceux gérés par Hibernate au sein de la couche serveur. Ceci évite tous les problèmes
potentiels de lazy loading en dehors des session hibernate. Ces beans pourront être implémentés par des beans standards
ou par des beans dynamiques. Dans tous les cas, l'utilisation de la librairie BeanUtils d'Apache facilitera la
manipulation de ces beans (cf. org.apache.commons.beanutils.DynaBean et org.apache.commons.beanutils.BasicDynaBean).
*/
//======================================================================================================================
//                                         Mise en oeuvre avec Spring
//======================================================================================================================
/*
L'adoption de Spring pour l'implémentation de l'accès au serveur simplifie grandement la tâche de développement.
*/

//======================================================================================================================
//                                        Business Delegate simple
//======================================================================================================================
/*
Le SimpleRemoteStatelessSessionProxyFactoryBean permet de construire dynamiquement des beans d'accès aux EJB,
prenant en compte les fonctions de Service Locator.

Les méthodes de délégation sont déclarées dans une interface qui reprend la plupart des méthodes présentes dans
l'interface remote de l'EJB, sans les RemoteException.
*/

/*

 interface HelloDelegate {
   HelloTO hello(String who);
}

//Le bean est ensuite déclaré (fichier ejb-client.xml) :

<bean id="helloDelegateSimple" lazy-init="true"
     class="org.springframework.ejb.access.
SimpleRemoteStatelessSessionProxyFactoryBean">

   <property name="jndiName" value="ejb/Hello" />
   <property name="businessInterface"
             value="info.jtips.j2ee.springdelegate.HelloDelegate" />
</bean>

//De cette façon, il est possible d'accéder à l'EJB de façon très souple, via le contexte Spring.

   final ApplicationContext ctx ;
   ctx = new ClassPathXmlApplicationContext(new String[] {"ejb-client.xml"});

   HelloDelegate del = (HelloDelegate)ctx.getBean("helloDelegateSimple");
   HelloTO hi = del.hello("someone"));
   ...
*/
//======================================================================================================================
//                                        Business Delegate élaboré
//======================================================================================================================
/*
La technique décrite dans le paragraphe précédent est efficace pour accéder aux EJB. Elle réduit considérablement
la dépendance entre le client et les EJB. Cependant, elle ne répond pas totalement aux objectifs du business delegate
car elle ne permet pas d'encapsuler la gestion des préoccupations périphériques. L'ajout de ces préoccupations peut
se faire par une technique de développement orientée aspect (AOP), elle aussi prise en compte par Spring.

Pour implémenter cette technique, nous développerons d'abord un intercepteur qui prendra en compte une préoccupation
spécifique (par exemple, gestion des exceptions).


                    class ExceptionHandlingInterceptor implements MethodInterceptor {

                     public Object invoke(MethodInvocation invocation) throws Throwable {
                       try {
                         return invocation.proceed();
                       } catch (ServerException e) {
                         throw new BusinessDelegateException(
                           "Problème de connexion au serveur", e.getCause());
                       } catch (Exception e) {
                         throw new BusinessDelegateException(e);
                       }
                     }
                   }


Cet intercepteur appel la méthode cible, puis attrape les exceptions ServerException.

Ensuite, il faut implémenter un bean dynamique (proxy) qui implémente l'interface de délégation, qui a pour cible
le bean de délégation simple et qui oriente systématiquement les appels vers l'intercepteur choisi.


                     <bean id="helloDelegate"
                           class="org.springframework.aop.framework.ProxyFactoryBean">
                         <property name="proxyInterfaces">
                             <value>info.jtips.j2ee.springdelegate.HelloDelegate</value>
                         </property>
                         <property name="target">
                             <ref local="helloDelegateSimple"/>
                         </property>
                         <property name="interceptorNames">
                            <list>
                                <value>exception</value>
                            </list>
                         </property>
                     </bean>


Dans une version plus avancée, il peut y avoir plusieurs intercepteurs et, surtout, les règles d'interception
peuvent être affinées par la mise en place de « pointcuts » et d'« advisors ».

L'accès aux EJB est tout aussi simple que précédemment :

                   final ApplicationContext ctx ;
                   ctx = new ClassPathXmlApplicationContext(new String[] {"ejb-client.xml"});

                   HelloDelegate del = (HelloDelegate)ctx.getBean("helloDelegate");
                   HelloTO hi = del.hello("someone"));
                   ...

*/
