using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Web_API_Proyecto2.Models
{
    public class DestinoTuristico
    {
        public int TN_Id { set; get; }
        public string TC_Nombre { set; get; }
        public string TC_Descripcion { set; get; }
        public string TC_Ubicacion { set; get; }
        public string TC_Link_Ubicacion { set; get; }
        public string TC_Video { set; get; }
        public decimal TN_Precio { set; get; }
        public string TC_Tipo_Visitas { set; get; }

    }
}
