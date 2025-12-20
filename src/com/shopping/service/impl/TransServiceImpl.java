package com.shopping.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.shopping.exception.ProductServiceException;
import com.shopping.exception.TransServiceException;
import com.shopping.service.TransService;
import com.shopping.utility.DBUtil;

public class TransServiceImpl implements TransService {

	@Override
	public String getUserId(String transId) {
		String userId = "";

		Connection con = DBUtil.provideConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			ps = con.prepareStatement("select username from transactions where transid=?");

			ps.setString(1, transId);

			rs = ps.executeQuery();

			if (rs.next())
				userId = rs.getString(1);

		} catch (SQLException e) {
			throw new TransServiceException("Get User Id - ", e);
		}

		return userId;
	}

}
