package model;

import java.util.Map;

import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Rain {
	@JsonProperty("1h")
	private Double _1h;
	
	@JsonIgnore
	private @Valid Map<String, Object> additionalProperties;

	public Rain(@Valid Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}

	public Double get_1h() {
		return _1h;
	}

	public void set_1h(Double _1h) {
		this._1h = _1h;
	}

	public @Valid Map<String, Object> getAdditionalProperties() {
		return additionalProperties;
	}

	public void setAdditionalProperties(@Valid Map<String, Object> additionalProperties) {
		this.additionalProperties = additionalProperties;
	}
}