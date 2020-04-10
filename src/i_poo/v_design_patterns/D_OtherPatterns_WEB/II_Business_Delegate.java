package i_poo.v_design_patterns.D_OtherPatterns_WEB;

public class II_Business_Delegate {
  public static void main(String[] args) {
   //===================================================================================================================
   //           6) Use BusinessDelegate and Client classes to demonstrate Business Delegate pattern.
   //===================================================================================================================

    BusinessDelegate businessDelegate = new BusinessDelegate();
    businessDelegate.setServiceType("EJB");

    Client client = new Client(businessDelegate);
    client.doTask();

    businessDelegate.setServiceType("JMS");
    client.doTask();
    /*
      Processing task by invoking EJB Service
      Processing task by invoking JMS Service
    */
  }
}

/*
Business delegate is a Java EE design pattern. [1] This pattern is directing to reduce the coupling in between
business services and the connected presentation tier, and to hide the implementation details of services
(including lookup and accessibility of EJB architecture).[1][2] Business delegates acts as an adaptor to invoke
business objects from the presentation tier.[3]

Business Delegate Pattern is used to decouple presentation tier and business tier. It is basically use to reduce
communication or remote lookup functionality to business tier code in presentation tier code. In business tier we
have following entities.

   .Client - Presentation tier code may be JSP, servlet or UI java code.
    ------

   .Business Delegate - A single entry point class for client entities to provide access to Business Service methods.
    -----------------

   .LookUp Service - Lookup service object is responsible to get relative business implementation and provide business
    --------------   object access to business delegate object.

   .Business Service - Business Service interface. Concrete classes implement this business service to provide actual
    ----------------   business implementation logic.

*/
//======================================================================================================================
//                                          Implementation
//======================================================================================================================
/*
We are going to create a Client, BusinessDelegate, BusinessService, LookUpService, JMSService and EJBService
representing various entities of Business Delegate patterns.

BusinessDelegatePatternDemo, our demo class, will use BusinessDelegate and Client to demonstrate use of
Business Delegate pattern.


                                                               -------------------------------------------
                                                               |                  Main                   |
                                                               -------------------------------------------
                                                               | + main() : void                         |
                                                               |                                         |
                                                               -------------------------------------------
                                                                                     |
                                                                                     | uses
                                                                                    \/
                                                               |----------------------------------------
----------------------------------                            \/                                        |
|        BusinessLookup          |             ---------------------------------                       \/
----------------------------------   uses      |       BusinessDelegate        |       ---------------------------------
|                                |<-------     ---------------------------------       |            Client             |
| + doProcessing() : void        |       |     | - lookup : BusinessLookup     |       ---------------------------------
----------------------------------       |     | - service  : BusinessService  |<------|  - service : BusinessDelegate |
                                         |-----| - serviceType : String        |       ---------------------------------
         <<Interface>>                   |     ---------------------------------       |  + Client( BusinessDelegate ) |
----------------------------------       |     | + setServiceType() : void     |       |  + doProcessing() : void      |
|        BusinessService         |       |     | + doTask() : void             |       ---------------------------------
----------------------------------       |     ---------------------------------
|                                |<-------
| + doProcessing() : void        |  uses
----------------------------------
              /\
              |                implement
              |---------------------------------------
              |                                      |
              |                                      |
----------------------------             ----------------------------
|        EJBService        |             |        JMSServive        |
----------------------------             ----------------------------
|                          |             |                          |
----------------------------             ----------------------------
| + doProcessing() : void  |             | + doProcessing() : void  |
----------------------------             ----------------------------
*/
//======================================================================================================================
//                               1) Create BusinessService Interface.
//======================================================================================================================
interface BusinessService {
  public void doProcessing();
}

//======================================================================================================================
//                               2) Create concrete Service classes.
//======================================================================================================================
class EJBService implements BusinessService {

  @Override
  public void doProcessing() {
    System.out.println("Processing task by invoking EJB Service");
  }
}

//===================================================================
class JMSService implements BusinessService {

  @Override
  public void doProcessing() {
    System.out.println("Processing task by invoking JMS Service");
  }
}

//======================================================================================================================
//                               3) Create Business Lookup Service.
//======================================================================================================================
class BusinessLookUp {
  public BusinessService getBusinessService(String serviceType) {
    if (serviceType.equalsIgnoreCase("EJB")) {
      return new EJBService();
    } else {
      return new JMSService();
    }
  }
}

//======================================================================================================================
//                               4) Create Business Delegate
//======================================================================================================================
class BusinessDelegate {
  private BusinessLookUp lookupService = new BusinessLookUp();
  private BusinessService businessService;
  private String serviceType;

  public void setServiceType(String serviceType) {
    this.serviceType = serviceType;
  }

  public void doTask() {
    businessService = lookupService.getBusinessService(serviceType);
    businessService.doProcessing();
  }
}

//======================================================================================================================
//                                    5) Create Client.
//======================================================================================================================
class Client {

  BusinessDelegate businessService;

  public Client(BusinessDelegate businessService) {
    this.businessService = businessService;
  }

  public void doTask() {
    businessService.doTask();
  }
}
