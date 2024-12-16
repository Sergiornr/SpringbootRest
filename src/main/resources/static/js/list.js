const container=document.getElementById("container-card")
const url="http://localhost:8080/usuarios"
window.addEventListener("load ",()=>{
    listarUsuarios()
})
function listarUsuarios(){
    
    let settings={method:"GET",headers: { 'Content-Type': 'application/json' }}
    fetch(url,settings)
    .then(response=>{if (!response.ok) {
        throw new Error("no se pudo realizar la peticion");
        
    }return response.json()
}).then(usuarios=>{console.log(usuarios);renderizar(usuarios)})
.catch(err=>console.error("error ", error))
}
function renderizar(users){
    let lista=[]
    users.forEach(element => {
        let template=`<div class="card"><h5>${element.name}</h5> <p>id ${element.id}</p></div>`
        lista.push(template)
    });container.innerHTML=lista
}