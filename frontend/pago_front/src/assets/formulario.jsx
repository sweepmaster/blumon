import React from "react";
import Datos from "../Pagos";


const checkInput=({target,key})=>{
    switch(target.name){
        case "cardNumber":
            if(target.value.length>15){
                target.value = target.value.substring(0, 15);
                          
                }
            
            
            break;
        case "cvv":;

        if(target.value.length>2){
            target.value = target.value.substring(0, 2);
                      
            }
            break;
        case "expirationDate":
            if(key=="Backspace"){
                target.value=""
            }
                      
            

        else if(target.value.length==2){
            if(target.value[3]!="/"){
                target.value+="/"
               
            }
         

        }


        else if(target.value.length>4){
            target.value = target.value.substring(0, 4);

            break;
            
    }
}



}

const submitInfo=(event,email)=>{


fetch("http://localhost:8080/pagos/",
{  headers: { 
    'Accept': 'application/json',
    'Content-Type': 'application/json' 
},

    method: "POST",
    body: JSON.stringify({
        
        "email":document.getElementById("email").value,
        "cardholderName":document.getElementById("cardholderName").value,
        "cardNumber":document.getElementById("cardNumber").value,
        "cvv":document.getElementById("cvv").value,

        "amount":document.getElementById("amount").value,
        "expirationYear":document.getElementById("expirationDate").value,
"expirationMonth":document.getElementById("expirationDate").value

      
    }
    
    )
}
)
  



}




export function FormularioPago({userEmail}){
return<>
<form id="formulario" onSubmit={submitInfo}>

    
<div id="form-container">
<div className="form-item">
  <input  type="text" id="cardholderName" name="cardholderName" required />
  <label for="cardholderName">Nombre Del Propetario</label>
</div>

<div className="form-item">
  <input onKeyDown={checkInput}  type="number"  id="cardNumber" name="cardNumber" required />
  <label for="cardNumber">Numero De Tarjeta</label>
</div>

<div className="form-item">
  <input onKeyDown={(e)=>checkInput(e)} type="text" id="expirationDate" name="expirationDate"  required/>
  <label for="expirationDate">Vigencia</label>
</div>

<div className="form-item">
  <input onKeyDown={(e)=>checkInput(e)} type="number" id="cvv" name="cvv" min={0} max={999} maxLength={3}  required/>
  <label for="cvv">Cvv</label>
</div>

<div className="form-item">
  <input onKeyDown={(e)=>checkInput(e)} type="number" id="Amount" name="amount" min={0} max={999}  required/>
  <label for="amount">Monto</label>
</div>


<div className="form-item"  >
<input id="submit" type="submit" />
</div>
</div>






</form>
<Datos email={userEmail}></Datos>

</>
}