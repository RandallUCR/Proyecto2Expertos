using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Threading.Tasks;

namespace Web_API_Proyecto2.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class PrincipalController : ControllerBase
    {

        public IConfiguration Configuration { get; }
        private string connectionString;
        public PrincipalController(IConfiguration configuration)
        {
            Configuration = configuration;
            connectionString = Configuration["ConnectionStrings:DefaultConnection"];
        }

        [HttpPost]
        [Route("GetDestino")]
        public Models.DestinoTuristico GetDestino([FromBody] Models.Ids id)
        {
            Models.DestinoTuristico salida = new Models.DestinoTuristico();
            if (ModelState.IsValid)
            {
                using (MySqlConnection connection = new MySqlConnection(connectionString))
                {
                    string sqlQuery = $"call sp_obtener_destino_turistico({id.id});";
                    using (MySqlCommand command = new MySqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        MySqlDataReader reader = command.ExecuteReader();
                        while (reader.Read())
                        {
                            salida.TN_Id = int.Parse(reader[0].ToString());
                            salida.TC_Nombre = reader[1].ToString();
                            salida.TC_Descripcion = reader[2].ToString();
                            salida.TC_Ubicacion = reader[3].ToString();
                            salida.TC_Link_Ubicacion = reader[4].ToString();
                            salida.TC_Video = reader[5].ToString();
                            salida.TN_Precio = decimal.Parse(reader[6].ToString());
                            salida.TC_Tipo_Visitas= reader[7].ToString();
                        }
                        connection.Close();
                    }
                }
            }

            return salida;
        }

        [HttpPost]
        [Route("GetRutaImagen")]
        public List<string> GetRutaImagen([FromBody] Models.Ids id)
        {
            List<string> salida = new List<string>();
            if (ModelState.IsValid)
            {
                using (MySqlConnection connection = new MySqlConnection(connectionString))
                {
                    string sqlQuery = $"call sp_obtener_ruta_imagen_destino({id.id});";
                    using (MySqlCommand command = new MySqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        MySqlDataReader reader = command.ExecuteReader();
                        while (reader.Read())
                        {
                            salida.Add(reader[0].ToString());
                        }
                        connection.Close();
                    }
                }
            }

            return salida;
        }

        [HttpPost]
        [Route("GetDestinosRecomendados")]
        public List<Models.DestinoRecomendado> GetDestinosRecomendados([FromBody] Models.Resultado r)
        {
            List<Models.DestinoRecomendado> salida = new List<Models.DestinoRecomendado>();
            if (ModelState.IsValid)
            {
                using (MySqlConnection connection = new MySqlConnection(connectionString))
                {
                    string sqlQuery = $"call sp_destinos_recomendados({r.resultadoUno}, {r.resultadoDos}, {r.resultadoTres}, {r.resultadoCuatro}, {r.resultadoCinco});";
                    using (MySqlCommand command = new MySqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        MySqlDataReader reader = command.ExecuteReader();
                        while (reader.Read())
                        {
                            Models.DestinoRecomendado d = new Models.DestinoRecomendado();
                            d.TN_Id = int.Parse(reader[0].ToString());
                            d.TC_Nombre = reader[1].ToString();
                            d.TC_Ruta_Imagen = reader[2].ToString();
                            d.TN_Tipo_Turismo = int.Parse(reader[3].ToString());

                            salida.Add(d);
                        }
                        connection.Close();
                    }
                }
            }

            return salida;
        }

        [HttpGet]
        [Route("GetDestinos")]
        public List<Models.DestinoUtil> GetDestinos()
        {
            List<Models.DestinoUtil> salida = new List<Models.DestinoUtil>();
            if (ModelState.IsValid)
            {
                using (MySqlConnection connection = new MySqlConnection(connectionString))
                {
                    string sqlQuery = $"call sp_obtener_destinos_turisticos;";
                    using (MySqlCommand command = new MySqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        MySqlDataReader reader = command.ExecuteReader();
                        while (reader.Read())
                        {
                            Models.DestinoUtil d = new Models.DestinoUtil();
                            d.TN_Id = int.Parse(reader[0].ToString());
                            d.TC_Nombre = reader[1].ToString();
                            d.TC_Tipo_Precio = reader[2].ToString();
                            d.TC_Tipo_Visitas = reader[3].ToString();
                            d.TC_Tipo_Turismo = reader[4].ToString();
                            d.TC_Ubicacion = reader[5].ToString();
                            d.TN_Precio = decimal.Parse(reader[6].ToString());
                            d.TC_Ruta_Imagen = reader[7].ToString();

                            salida.Add(d);
                        }
                        connection.Close();
                    }
                }
            }

            return salida;
        }

        [HttpGet]
        [Route("GetDestinosCriterio")]
        public List<Models.DestinoCriterio> GetDestinosCriterio()
        {
            List<Models.DestinoCriterio> salida = new List<Models.DestinoCriterio>();
            if (ModelState.IsValid)
            {
                using (MySqlConnection connection = new MySqlConnection(connectionString))
                {
                    string sqlQuery = $"call sp_lista_destinos;";
                    using (MySqlCommand command = new MySqlCommand(sqlQuery, connection))
                    {
                        command.CommandType = CommandType.Text;
                        connection.Open();
                        MySqlDataReader reader = command.ExecuteReader();
                        while (reader.Read())
                        {
                            Models.DestinoCriterio d = new Models.DestinoCriterio();
                            d.TN_Id_Cb = int.Parse(reader[0].ToString());
                            d.TN_Id_Dt = int.Parse(reader[1].ToString());
                            d.TN_Provincia = int.Parse(reader[2].ToString());
                            d.TN_Precio = int.Parse(reader[3].ToString());
                            d.TN_Tipo_Visitas = int.Parse(reader[4].ToString());
                            d.TN_Tipo_Turismo = int.Parse(reader[5].ToString());

                            salida.Add(d);
                        }
                        connection.Close();
                    }
                }
            }

            return salida;
        }

    }
}
