package cn.javaex.office.excel.help;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import cn.javaex.office.excel.ExcelUtils;

/**
 * 行
 * 
 * @author 陈霓清
 */
public class RowHelper {

	/**
	 * 复制行及其数据
	 * 
	 * @param sheet
	 * @param oldRow
	 * @param newRow
	 */
	public void copyRow(Sheet sheet, Row oldRow, Row newRow) {
		// 复制行高
		if (oldRow.getHeight()>=0) {
			newRow.setHeight(oldRow.getHeight());
		}
		
		// 循环复制单元格
		for (int i=oldRow.getFirstCellNum(); i<oldRow.getLastCellNum(); i++) {
			Cell oldCell = oldRow.getCell(i);
			Cell newCell = newRow.getCell(i);
			
			if (oldCell!=null) {
				if (newCell==null) {
					newCell = newRow.createCell(i);
				}
				
				// 复制单元格和样式
				this.copyCell(oldCell, newCell);
			}
		}
	}

	/**
	 * 复制单元格和样式
	 * @param oldCell
	 * @param newCell
	 */
	private void copyCell(Cell oldCell, Cell newCell) {
		// 复制样式
		newCell.setCellStyle(oldCell.getCellStyle());
		
		// 复制值
		newCell.setCellValue(ExcelUtils.getCellValue(oldCell));
	}

}
