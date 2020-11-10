package Modelo;

public class Casella {
	
	private int m_Valor;
	private boolean m_Abierta;
	private boolean m_Bandera;
	
	public Casella()
	{
		m_Valor = 0;
		m_Abierta = false;
		m_Bandera = false;
	}
	
	public void setValor(int valor)
	{
		m_Valor = valor;
	}
	
	public int getValor()
	{
		return m_Valor;
	}
	
	public void setAbierta(boolean valor)
	{
		 m_Abierta = valor;
	}
	
	public boolean getAbierta()
	{
		return m_Abierta;
	}
	
	public void setBandera(boolean valor)
	{
		 m_Bandera = valor;
	}
	
	public boolean getBandera()
	{
		return m_Bandera;
	}
	
}
