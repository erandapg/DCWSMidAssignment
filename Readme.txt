Deployment procedure (Server - DCWSHospitalSystem)
============================
Build eclipse project using below commands.
Cd {workspace}\DCWSHospitalSystem
Mvn –Dmaven.test.skip=true clean package

Copy war file in project target falder in to below path
{wso2as-5.3.0_home}\repository\deployment\server\webapps

Start wso2as server using below command
Cd {wso2as-5.3.0_home}\bin
./ wso2server.sh start

After creating tables automatically, should insert user data manually 


Deploy Procedure (Client - DCWSHospitalClient)
========================
PHP Client need to be deploy in XAMP server.

Deploy ESB API
==============
Go to ESB carbon admin console
Go to API link 
Create New API and copy paste below configurations.

<api xmlns="http://ws.apache.org/ns/synapse" name="paymentGatewayTest" context="/dcws/hospitalsystem">
   <resource methods="OPTIONS POST" uri-template="/ccpayment/requests/{amount}/{cardHolderName}/{ccNumber}" faultSequence="fault">
      <inSequence>
         <log level="custom">
            <property name="amount" expression="get-property('uri.var.amount')"/>
         </log>
         <payloadFactory media-type="json">
            <format>{    "amount": "$1",    "cardHolderName": "$2",    "ccNumber": "$3",    "currency": "$4",    "cvcNumber": "$5",    "language": "$6",    "orderId": "$7",    "paymentType": "$8",    "responseUrl": "$9",    "userId": "$10"    }                 </format>
            <args>
               <arg evaluator="json" expression="get-property('uri.var.amount')"/>
               <arg evaluator="json" expression="get-property('uri.var.cardHolderName')"/>
               <arg evaluator="json" expression="get-property('uri.var.ccNumber')"/>
               <arg evaluator="json" expression="get-property('uri.var.currency')"/>
               <arg evaluator="json" expression="get-property('uri.var.cvcNumber')"/>
               <arg evaluator="json" expression="get-property('uri.var.language')"/>
               <arg evaluator="json" expression="get-property('uri.var.orderId')"/>
               <arg evaluator="json" expression="get-property('uri.var.paymentType')"/>
               <arg evaluator="json" expression="get-property('uri.var.responseUrl')"/>
               <arg evaluator="json" expression="get-property('uri.var.responseUrl')"/>
            </args>
         </payloadFactory>
         <send>
            <endpoint>
               <http method="POST" uri-template="http://localhost:8080/rest/hospital/invokePaymentGateway"/>
            </endpoint>
         </send>
      </inSequence>
      <outSequence>
         <log level="custom">
            <property name="status" expression="json-eval($.status)"/>
            <property name="transactionId" expression="json-eval($.transactionId)"/>
         </log>
         <property name="NO_ENTITY_BODY" scope="axis2" action="remove"/>
         <property name="messageType" value="application/json" scope="axis2" type="STRING"/>
         <log level="full"/>
         <send/>
      </outSequence>
   </resource>
   <resource methods="OPTIONS POST" uri-template="/mobilepayment/requests/{amount}/{cardHolderName}/{ccNumber}" faultSequence="fault">
      <inSequence>
         <log level="custom">
            <property name="amount" expression="get-property('amount')"/>
         </log>
         <payloadFactory media-type="json">
            <format>{    "amount": "$1",    "cardHolderName": "$2",    "ccNumber": "$3",    "currency": "$4",    "cvcNumber": "$5",    "language": "$6",    "orderId": "$7",    "paymentType": "$8",    "responseUrl": "$9",    "userId": "$10"    }                 </format>
            <args>
               <arg evaluator="json" expression="get-property('uri.var.amount')"/>
               <arg evaluator="json" expression="get-property('uri.var.cardHolderName')"/>
               <arg evaluator="json" expression="get-property('uri.var.ccNumber')"/>
               <arg evaluator="json" expression="get-property('uri.var.currency')"/>
               <arg evaluator="json" expression="get-property('uri.var.cvcNumber')"/>
               <arg evaluator="json" expression="get-property('uri.var.language')"/>
               <arg evaluator="json" expression="get-property('uri.var.orderId')"/>
               <arg evaluator="json" expression="get-property('uri.var.paymentType')"/>
               <arg evaluator="json" expression="get-property('uri.var.responseUrl')"/>
               <arg evaluator="json" expression="get-property('uri.var.responseUrl')"/>
            </args>
         </payloadFactory>
         <send>
            <endpoint>
               <http method="POST" uri-template="http://localhost:8080/rest/hospital/invokePaymentGateway"/>
            </endpoint>
         </send>
      </inSequence>
      <outSequence>
         <log level="custom">
            <property name="status" expression="json-eval($.status)"/>
            <property name="transactionId" expression="json-eval($.transactionId)"/>
         </log>
         <property name="NO_ENTITY_BODY" scope="axis2" action="remove"/>
         <property name="messageType" value="application/json" scope="axis2" type="STRING"/>
         <log level="full"/>
         <send/>
      </outSequence>
   </resource>
</api>
