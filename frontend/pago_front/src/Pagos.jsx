import { useEffect, useState } from "react";


export default function Datos({email}) {
  const [isLoading, setIsLoading] = useState(true);
  const [data, setData] = useState(null);

  useEffect(() => {
    fetch("http://localhost:8080/pagos/",
        {  headers: { 
            'Accept': 'application/json',
            'Content-Type': 'application/json' 
        },
    
            method: "POST",
            body: JSON.stringify({
                
                "email":email
              
            }
            
            )
        }
    )
      .then((response) => response.json())
      .then((data) => {
        console.log(data)
        setData(data);
        setIsLoading(false);
      });
  }, []);

  if (isLoading) { 
    return (
      <div>
        <h1>Cargando...</h1>
      </div>
    );
  }//{"idPago":1,"status":1,"cantidad":3000,"email":"leonidas06051997@gmail.com","numeroTarjeta":"4111111111111111","marca":"mastercard","banco":"banamex"}


  return (
    <div>
      {data.map(element => {
        return <>
      


        </>
        
      })}
     
    </div>
  );
}