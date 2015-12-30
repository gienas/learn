 <session-bean>
    <stateless>
      <bean-instance-pool-ref pool-name="slsb-strict-max-pool"/>
    </stateless>

    Scenario:
    1. Create business service
    2. Create Domain classes
    3. Create controlers
       - OPT: pooling
       - OPT: jmeter 
       	- Implement bean counter (Singleton)
       	- Insert sleep in weather Bean 
       - Remote call - without serializable, with serializable
    4. Create GUI
    