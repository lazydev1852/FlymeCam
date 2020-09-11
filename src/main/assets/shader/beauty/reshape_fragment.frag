precision mediump float;
    varying vec2 textureCoordinate;
    uniform sampler2D vTexture;
    uniform float aspectRatio;  // 所处理图像的宽高比
	uniform float leftContourPoints[6];
	uniform float rightContourPoints[6];
    //************** 更新数据形式
    uniform vec2 leftContourPoints_vec[3];
    uniform vec2 rightContourPoints_vec[3];
    uniform bool boolFaceScale;

	uniform float faceWarpRadius;     // 形变半径   ,origin 0.17  ,0.1 bearly ,0.15 middle
	uniform float deltaArray[3];       // strength, 形变量，要大于radius，good at 3 times radius
	const int arraySize = 3;

	uniform vec2 rightEyeCenter;
	uniform vec2 leftEyeCenter;
	uniform float eyeScaleRadius;       // 眼睛缩放算法的作用域半径
	uniform float eyeScaleFactor;      // 眼睛缩放参数

    //  Scale Function for eyes
	//	local scaling warps suitable for nature eyes
	//  The calculation below refers to thesis "Interactive Image Warping - Andreas Gustafson" on page 41
	highp vec2 warpScaleToUse(vec2 centerPostion, vec2 currentPosition, float radius, float scaleRatio, float aspectRatio){
		vec2 positionToUse = currentPosition;
		vec2 currentPositionToUse = vec2(currentPosition.x, currentPosition.y * aspectRatio + 0.5 - 0.5 * aspectRatio);
		vec2 centerPostionToUse = vec2(centerPostion.x, centerPostion.y * aspectRatio + 0.5 - 0.5 * aspectRatio);
		float r = distance(currentPositionToUse, centerPostionToUse);
		if(r < radius){
			float alpha = 1.0 - scaleRatio * pow(r / radius - 1.0, 2.0);
			positionToUse = centerPostion + alpha * (currentPosition - centerPostion);
		}
		return positionToUse;
	}

    // Reposition Function
    // warp points in certain radius
    // this method perform great in effect, but a little bitte expensive
	highp vec2 warpPositionToUse(vec2 currentPoint, vec2 contourPointA,  vec2 contourPointB, float radius, float delta, float aspectRatio){
		vec2 positionToUse = currentPoint;
		vec2 currentPointToUse = vec2(currentPoint.x, currentPoint.y * aspectRatio + 0.5 - 0.5 * aspectRatio);
		vec2 contourPointAToUse = vec2(contourPointA.x, contourPointA.y * aspectRatio + 0.5 - 0.5 * aspectRatio);
		// The calculation below refers to thesis "Interactive Image Warping - Andreas Gustafson" on page 38
		float r = distance(currentPointToUse, contourPointAToUse);
		if(r < radius){
			vec2 dir = normalize(contourPointB - contourPointA);
			float dist = radius * radius - r * r;
			float alpha = dist / (dist + (r-delta) * (r-delta));
			alpha = alpha * alpha;
			positionToUse = positionToUse - alpha * delta * dir;
		}
		return positionToUse;
	}

    // Reposition Function
    // Mesh warp
	highp vec2 meshWarp(vec2 textureCoord, vec2 originPosition, vec2 targetPosition, float radius, float curve)
    {
    	vec2 direction = targetPosition - originPosition;
    	float lengthA = length(direction);
    	if(lengthA<0.0001)   return direction;
    	float lengthB = min(lengthA, radius);
    	direction *= lengthB / lengthA;
    	float infect = distance(textureCoord, originPosition)/radius;
    	infect = clamp(1.0-infect,0.0,1.0);
    	infect = pow(infect, curve);
    	return direction * infect;
    }

    // Test Code for Reposition
	highp vec2 reposition(vec2 currentPosition,vec2 rightEyeCenter,vec2 leftEyeCenter){
	    float warpStrength = 5.2;
	    float radius = 0.1;

		vec2 curCoord = currentPosition;
        vec2 srcPoint = vec2(0.0);
        vec2 dstPoint = vec2(0.0);
        srcPoint = rightEyeCenter;
        dstPoint = srcPoint+(leftEyeCenter-srcPoint)*warpStrength;

        vec2 offset = meshWarp(curCoord,srcPoint,dstPoint,radius,1.0);
        curCoord = curCoord-offset;
		return curCoord;
	}

	void main(){
		vec2 positionToUse = textureCoordinate;
		// Eyes reshape
		positionToUse = warpScaleToUse(rightEyeCenter, positionToUse, eyeScaleRadius, eyeScaleFactor, aspectRatio);
		positionToUse = warpScaleToUse(leftEyeCenter, positionToUse, eyeScaleRadius, eyeScaleFactor, aspectRatio);

		// Face reshape
		if(boolFaceScale){
            for(int i = 0; i < arraySize; i++){
                positionToUse = warpPositionToUse(positionToUse, leftContourPoints_vec[i], rightContourPoints_vec[i], faceWarpRadius, deltaArray[i], aspectRatio);
                positionToUse = warpPositionToUse(positionToUse, rightContourPoints_vec[i], leftContourPoints_vec[i], faceWarpRadius, deltaArray[i], aspectRatio);
            }
		}

        // Mesh Warp
//        positionToUse = reposition(positionToUse,rightEyeCenter,leftEyeCenter);

		gl_FragColor = texture2D(vTexture, positionToUse);
	}