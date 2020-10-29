package br.ufc.crateus.ccompiler.syntactic.productions;

import java.util.Arrays;
import java.util.List;

public class Production {
	private List<ProductionType> productionTypes;
	private int id;

	private Production(List<ProductionType> productionTypes, int id) {
		this.productionTypes = productionTypes;
		this.id = id;
	}

	public static Production of(int id, ProductionType... productionTypes) {
		return new Production(Arrays.asList(productionTypes), id);
	}

	public List<ProductionType> getProductionTypes() {
		return productionTypes;
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		if (productionTypes.isEmpty()) {
			sb.append("e");
		} else {
			productionTypes.forEach(productionType -> {
				sb.append(productionType);
				sb.append(" ");
			});
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public boolean equalsById(int id) {
		return this.id == id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Production other = (Production) obj;
		return id == other.id;
	}

}
