package BuscaMines;

public class Casella {
	
	private int m_Valor;
	private boolean m_Abierta;
	
	public Casella()
	{
		m_Valor = 0;
		m_Abierta = false;
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
	
}
