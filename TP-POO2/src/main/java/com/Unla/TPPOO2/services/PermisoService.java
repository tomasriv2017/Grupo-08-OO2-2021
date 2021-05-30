package com.Unla.TPPOO2.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Unla.TPPOO2.interfaceService.IPermisoService;
import com.Unla.TPPOO2.interfaces.IPermiso;
import com.Unla.TPPOO2.models.Permiso;

@Service
public class PermisoService implements IPermisoService{
	@Autowired
	private IPermiso data;

	@Override
	public List<Permiso> listar() {
		// TODO Auto-generated method stub
		return (List<Permiso>) data.findAll();
	}

	@Override
	public Optional<Permiso> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public void delete(int id) throws Exception {
		// TODO Auto-generated method stub
		if (listarId(id) == null)
			throw new Exception("El permiso con id: " + id + " no existe");
		else data.deleteById(id);
	}

	@Override
	public int save(Permiso p) {
		// TODO Auto-generated method stub
		int res = 0;
		Permiso permiso=data.save( p);
		if(!permiso.equals(null)) {
			res=1;
		}
		return res;
	}
	
}